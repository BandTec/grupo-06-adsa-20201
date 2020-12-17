package br.com.bandtec.slack.api;

public class ExampleMessage {

    public static void main(String[] args) {

        Message slackMessage = Message
                .builder()
                .text("TESTE DE MAQUINA MACHINETCH: ISSO É UM TESTE DE MENSAGEM")
                .build();

        SendMessage.sendMessage(slackMessage);

    }

}
    