package bot;

import example.bot.*;
import org.junit.Assert;
import org.junit.Test;

public class BotTest {
    @Test
    public void testCommandTest() throws InterruptedException {
        FakeBot bot = new FakeBot();
        BotLogic botLogic = new BotLogic(bot);
        User user = new User(111L);

        botLogic.processCommand(user, "/test");
        Thread.sleep(1010);
        //Assert.assertEquals(user.getState(), State.TEST);

        Assert.assertEquals("Вычислите степень: 10^2", bot.getMessages().get(0));
        botLogic.processCommand(user, "100");
        Thread.sleep(1010);
        Assert.assertEquals("Правильный ответ!", bot.getMessages().get(1));
        Assert.assertEquals("Сколько будет 2 + 2 * 2", bot.getMessages().get(2));
        botLogic.processCommand(user, "6");
        Thread.sleep(1010);
        Assert.assertEquals("Правильный ответ!", bot.getMessages().get(3));

        Assert.assertEquals("Тест завершен", bot.getMessages().get(4));

    }
    @Test
    public void notifyCommandTest(){

    }
    @Test
    public void repeatCommandTest(){

    }
}
