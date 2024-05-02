package bot;

import example.bot.*;
import org.junit.Assert;
import org.junit.Test;

public class BotTest {
    @Test
    public void rightTestCommandTest() {
        FakeBot bot = new FakeBot();
        BotLogic botLogic = new BotLogic(bot);
        User user = new User(111L);

        botLogic.processCommand(user, "/test");

        Assert.assertEquals("Вычислите степень: 10^2", bot.getMessages().get(0));
        botLogic.processCommand(user, "100");
        Assert.assertEquals("Правильный ответ!", bot.getMessages().get(1));
        Assert.assertEquals("Сколько будет 2 + 2 * 2", bot.getMessages().get(2));
        botLogic.processCommand(user, "6");
        Assert.assertEquals("Правильный ответ!", bot.getMessages().get(3));

        Assert.assertEquals("Тест завершен", bot.getMessages().get(4));

    }

    @Test
    public void wrongTestCommandTest() {
        FakeBot bot = new FakeBot();
        BotLogic botLogic = new BotLogic(bot);
        User user = new User(111L);

        botLogic.processCommand(user, "/test");

        Assert.assertEquals("Вычислите степень: 10^2", bot.getMessages().get(0));
        botLogic.processCommand(user, "12");
        Assert.assertEquals("Вы ошиблись, верный ответ: 100", bot.getMessages().get(1));
        Assert.assertEquals(1, user.getWrongAnswerQuestions().size());
        Assert.assertEquals("Сколько будет 2 + 2 * 2", bot.getMessages().get(2));
        botLogic.processCommand(user, "2003");
        Assert.assertEquals("Вы ошиблись, верный ответ: 6", bot.getMessages().get(3));
        Assert.assertEquals(2, user.getWrongAnswerQuestions().size());

        Assert.assertEquals("Тест завершен", bot.getMessages().get(4));

    }

    @Test
    public void notifyCommandTest() throws InterruptedException {
        FakeBot bot = new FakeBot();
        BotLogic botLogic = new BotLogic(bot);
        User user = new User(111L);

        botLogic.processCommand(user, "/notify");

        Assert.assertEquals("Введите текст напоминания", bot.getMessages().get(0));
        botLogic.processCommand(user, "Первое напоминание");
        Assert.assertEquals("Через сколько секунд напомнить?", bot.getMessages().get(1));
        botLogic.processCommand(user, "5");
        Assert.assertEquals("Напоминание установлено", bot.getMessages().get(2));
        Assert.assertEquals(3, bot.getMessages().size());

        Thread.sleep(5100);
        Assert.assertEquals("Сработало напоминание: 'Первое напоминание'", bot.getMessages().get(3));
    }
    @Test
    public void repeatCommandTest(){
        FakeBot bot = new FakeBot();
        BotLogic botLogic = new BotLogic(bot);
        User user = new User(111L);

        botLogic.processCommand(user, "/repeat");
        //TODO
    }
}
