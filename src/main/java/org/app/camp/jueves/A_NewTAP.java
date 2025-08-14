package org.app.camp.jueves;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class A_NewTAP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line.trim());
            if (!st.hasMoreTokens()) continue;
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int b0 = X - 1;      // equipos más fuertes que X
            int w0 = N - X;      // equipos más débiles que X

            // Caso trivial: si b0 == 0, X nunca puede perder → campeón seguro
            if (b0 == 0) {
                if (Y == 1) System.out.printf("1.0000%n");
                else       System.out.printf("0.0000%n");
                continue;
            }

            // Ronda en la que, de morir, X quedaría en posición Y
            int R = (Y == 1 ? N - 1 : (N - Y + 1));

            // DP: f[b] = probabilidad de estar en estado (b, w) al inicio de la ronda r
            double[] f     = new double[b0 + 1];
            double[] fNext = new double[b0 + 1];
            f[b0] = 1.0;

            // ans[r] = probabilidad de que X muera **exactamente** en la ronda r
            double[] ans = new double[R + 1];

            // Número inicial de equipos vivos (incluyendo X)
            int totalStart = 1 + b0 + w0;

            for (int r = 1; r <= R; r++) {
                int survivorsBefore = totalStart - (r - 1);
                int t = survivorsBefore;      // t = 1 + b + w
                // precomputamos combinatoria de (t-2 choose 2) si t-2 >= 2
                double cT2 = (t >= 3) ? ((double)(t-2) * (t-3) / 2.0) : 1.0;

                // recorrer b tal que 0 ≤ b ≤ b0 y w = survivorsBefore - 1 - b en [0..w0]
                for (int b = Math.max(0, survivorsBefore - 1 - w0);
                     b <= Math.min(b0, survivorsBefore - 1);
                     b++) {
                    double pState = f[b];
                    if (pState == 0.0) continue;
                    int w = (survivorsBefore - 1) - b;

                    // 1) Probabilidad de que X sea seleccionado y pierda →
                    double pDie = (2.0 / t) * ((double)b / (t - 1));
                    ans[r] += pState * pDie;

                    // 2) Transiciones de supervivencia
                    //   a) X juega vs débil y gana:
                    if (w > 0) {
                        double pWin = (2.0 / t) * ((double)w / (t - 1));
                        fNext[b] += pState * pWin;  // w→w-1, pero w se deduce de r y b
                    }
                    //   b) Otros juegan entre sí:
                    double pOther = (t - 2.0) / t;
                    if (cT2 > 0) {
                        // dos fuertes
                        if (b >= 2) {
                            double p2strong = ((double)b * (b - 1) / 2.0) / cT2;
                            fNext[b-1] += pState * pOther * p2strong;
                        }
                        // dos débiles + mixto ambos eliminan un débil
                        if (w >= 1) {
                            double p2weak = (w >= 2
                                    ? ((double)w * (w - 1) / 2.0) / cT2
                                    : 0.0);
                            double pMixed= ((double)b * w) / cT2;
                            fNext[b] += pState * pOther * (p2weak + pMixed);
                        }
                    }
                }

                // preparar siguiente ronda: f←fNext, luego limpiar fNext
                for (int i = 0; i <= b0; i++) {
                    f[i] = fNext[i];
                    fNext[i] = 0.0;
                }
            }

            double result;
            if (Y == 1) {
                // probabilidad de NO morir en ninguna de las R=N-1 rondas
                double sumDie = 0.0;
                for (int r = 1; r <= N-1; r++) sumDie += ans[r];
                result = 1.0 - sumDie;
            } else {
                result = ans[R];
            }

            System.out.printf("%.4f%n", result);
        }
    }
}