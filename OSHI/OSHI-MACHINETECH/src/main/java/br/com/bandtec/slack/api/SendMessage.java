package br.com.bandtec.slack.api;


    import com.fasterxml.jackson.databind.ObjectMapper ;
import com.mycompany.API.Log;
    import org.apache.http.client.methods.HttpPost ;
    import org.apache.http.entity.StringEntity ;
    import org.apache.http.impl.client.CloseableHttpClient ;
    import org.apache.http.impl.client.HttpClients ;

    import java.io.IOException ;

    public class SendMessage {

        private static String slackWebhookUrl = "https://hooks.slack.comENDO/services/T01EWTB3MLY/B01GB26S65S/OszWXcxAuhqTZtzXw6nPTUdr";

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
                Log adicionarLog = new Log();
                adicionarLog.addLog("Log.txt", "[ERRO]", "Link de acesso ao Slack expirou.");
            }
        }
    }
