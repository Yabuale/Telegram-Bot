package tutorial;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Objects;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "yabu_yb_bot";
    }

    @Override
    public String getBotToken() {
        return "5959902199:AAHIPaHHOvH3sbjUcUzpvFqgTikwWYe5jRg";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();
        var name = "BENA";
        var fullname="BENA ቤናዊ";

        if(Objects.equals(user.getFirstName().toString(),name.toString())||Objects.equals(user.getFirstName().toString(),fullname.toString())){
            sendText(id, "Hello MR. "+user.getFirstName()+" Hope you like my bot");


        }
        else {

            sendText(id, "Hello "+user.getFirstName()+" "+msg.getText() + " right back at you \uD83D\uDE09 contact me @yabu_yb");
        }
    }



    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) 
                .text(what).build();    
        try {
            execute(sm);                        
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      
        }
    }
}
