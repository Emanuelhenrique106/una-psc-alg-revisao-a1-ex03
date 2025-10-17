public class ProcessadorRisco {
    public static void main(String[] args) {
        
    
        Locale.setDefault(Locale.US);

        // tenho que Usar um vetor de 15 notas 
        int[] notasRisco = {
            92, // analista 0 (sênior)...
            85, // analista 1 
            76, // analista 2 
            15, // analista 3 
            40, // analista 4 
            10, // analista 5 (júnior)...
            33, // analista 6 
            55, // analista 7 
            98, // analista 8 
            20, // analista 9 
            67, // analista 10 
            44, // analista 11 
            12, // analista 12 
            90, // analista 13 
            28, // analista 14 
        };

        // 2) Cálculo da média ponderada
        
        double somaPonderada = 0.0;
        int somaPesos = 0;
        for (int i = 0; i < notasRisco.length; i++) {
            int peso;
            if (i >= 0 && i <= 4) {
                peso = 3; // sêniores: índices 0 a 4
            } else {
                peso = 1; // juniores: índices 5 a 14
            }
            somaPonderada += notasRisco[i] * peso;
            somaPesos += peso;
        }
        double mediaPonderada = somaPonderada / somaPesos;

        // 3) Contagem de Otimistas (nota <= 20) e Alarmantes (nota >= 90)
        int countOtimistas = 0;
        int countAlarmantes = 0;
        for (int nota : notasRisco) {
            if (nota <= 20) {
                countOtimistas++;
            }
            if (nota >= 90) {
                countAlarmantes++;
            }
        }

        // 4) Saída dos valores calculados
        System.out.printf("Média Ponderada do Risco: %.2f%n", mediaPonderada);
        System.out.println("Quantidade de analistas Otimistas (nota <= 20): " + countOtimistas);
        System.out.println("Quantidade de analistas Alarmantes (nota >= 90): " + countAlarmantes);

        // 5) Parecer final com if - else if - else
        if (mediaPonderada > 70) {
            System.out.println("Parecer: Alto Risco: Venda ou reajuste de portfólio recomendado.");
        } else if (mediaPonderada >= 40 && mediaPonderada <= 70) {
            System.out.println("Parecer: Risco Moderado: Acompanhar de perto, mas manter os ativos.");
        } else { // mediaPonderada < 40
            System.out.println("Parecer: Baixo Risco: Excelente momento para capitalização.");
        }
    }
}