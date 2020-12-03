

package br.com.bandtec.slack.api;

import lombok.*;
  
  import java.io.Serializable;

  @AllArgsConstructor
  @Builder(builderClassName = "Builder")
  @Getter
  @Setter
  @NoArgsConstructor
public class Message implements Serializable {
 
    private String text;
    
}