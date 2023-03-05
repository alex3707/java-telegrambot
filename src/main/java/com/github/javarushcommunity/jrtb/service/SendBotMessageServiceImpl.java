package com.github.javarushcommunity.jrtb.service;

import com.github.javarushcommunity.jrtb.bot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendBotMessageServiceImpl implements SendBotMessageService{
    private final TelegramBot javarushBot;
    @Autowired
    public SendBotMessageServiceImpl(TelegramBot javarushBot) {
        this.javarushBot = javarushBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            javarushBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add logging to the project.
            e.printStackTrace();
        }

    }
}
