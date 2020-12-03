package br.com.bandtec.slack.api;


    import com.fasterxml.jackson.databind.ObjectMapper ;
    import org.apache.http.client.methods.HttpPost ;
    import org.apache.http.entity.StringEntity ;
    import org.apache.http.impl.client.CloseableHttpClient ;
    import org.apache.http.impl.client.HttpClients ;

    import java.io.IOException ;

    public class SendMessage {

//        private static String slackWebhookUrl = "https://hooks.slack.com/services/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";

        public static void sendMessage(Message message) {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(slackWebhookUrl);

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(message);

                StringEntity entity = new StringEntity(json);
                httpPost.setEntity(entity);
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json");

                client.execute(httpPost);
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
