package com.kshrd.coffeeshop.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
public class MyTelegramBot {

    @Value("${telegram_token}")
    private String telegramToken;
    @Value("${chat_id}")
    private Long chatId;

    private TelegramBot bot;

    public SendResponse sendMessage(String message) {
        if (bot == null)
            bot = new TelegramBot(telegramToken);
        return bot.execute(new SendMessage(chatId, message));
    }

}
