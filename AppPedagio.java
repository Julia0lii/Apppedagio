public class AppPedagio {

    public static void main(String[] args) {
        Veiculo v1 = new Carro();
        Veiculo v2 = new Caminhao(4); 
        Veiculo v3 = new Moto();

        processarPedagio(v1);
        processarPedagio(v2);
        processarPedagio(v3);

        RelatorioPedagio.exibirRelatorio();
    }

    public static void processarPedagio(Veiculo veiculo) {
        double valor = veiculo.calcularPedagio();
        System.out.printf("Veículo: %s | Valor do Pedágio: R$ %.2f%n", veiculo.getTipo(), valor);
        RelatorioPedagio.adicionarValor(valor);
    }


    interface Veiculo {
        double calcularPedagio();
        String getTipo();
    }

    
    static class Carro implements Veiculo {
        public double calcularPedagio() {
            return 5.00;
        }

        public String getTipo() {
            return "Carro";
        }
    }

    
    static class Caminhao implements Veiculo {
        private int eixos;

        public Caminhao(int eixos) {
            this.eixos = eixos;
        }

        public double calcularPedagio() {
            return 10.00 + (2.00 * eixos);
        }

        public String getTipo() {
            return "Caminhão";
        }
    }

   
    static class Moto implements Veiculo {
        public double calcularPedagio() {
            return 2.50;
        }

        public String getTipo() {
            return "Moto";
        }
    }

    
    static class RelatorioPedagio {
        private static int totalVeiculos = 0;
        private static double totalArrecadado = 0;

        public static void adicionarValor(double valor) {
            totalVeiculos++;
            totalArrecadado += valor;
        }

        public static void exibirRelatorio() {
            System.out.println("==== RELATÓRIO DO PEDÁGIO ====");
            System.out.println("Total de veículos: " + totalVeiculos);
            System.out.printf("Total arrecadado: R$ %.2f%n", totalArrecadado);
        }
    }
}

