package top.knos.captcha;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 测试类
 * Created by 王帆 on 2018-07-27 上午 10:08.
 */
public class CaptchaTest {

    @Test
    public void test() throws Exception {
        /*for (int i = 0; i < 10; i++) {
            PngCaptcha pngCaptcha = new PngCaptcha();
            pngCaptcha.setLen(4);
            pngCaptcha.setFont(i, 32f);
            System.out.println(pngCaptcha.text());
            PngCaptcha.out(new FileOutputStream(new File("C:/Java/aa" + i + ".png")));
        }*/
    }

    @Test
    public void testGIf() throws Exception {
        /*for (int i = 0; i < 10; i++) {
            GifCaptcha gifCaptcha = new GifCaptcha();
            gifCaptcha.setLen(5);
            gifCaptcha.setFont(i, 32f);
            System.out.println(gifCaptcha.text());
            gifCaptcha.out(new FileOutputStream(new File("C:/Java/aa" + i + ".gif")));
        }*/
    }

    @Test
    public void testHan() throws Exception {
        /*for (int i = 0; i < 10; i++) {
            ChineseCaptcha chineseCaptcha = new ChineseCaptcha();
            System.out.println(chineseCaptcha.text());
            chineseCaptcha.out(new FileOutputStream(new File("C:/Java/aa" + i + ".png")));
        }*/
    }

    @Test
    public void testGifHan() throws Exception {
        /*for (int i = 0; i < 10; i++) {
            ChineseGifCaptcha chineseGifCaptcha = new ChineseGifCaptcha();
            System.out.println(chineseGifCaptcha.text());
            chineseGifCaptcha.out(new FileOutputStream(new File("C:/Java/aa" + i + ".gif")));
        }*/
    }

    @Test
    public void testArit() throws Exception {
        /*for (int i = 0; i < 10; i++) {
            ArithmeticCaptcha pngCaptcha = new ArithmeticCaptcha();
            pngCaptcha.setLen(3);
            pngCaptcha.setFont(i, 28f);
            System.out.println(pngCaptcha.getArithmeticString() + " " + pngCaptcha.text());
            PngCaptcha.out(new FileOutputStream(new File("C:/Java/aa" + i + ".png")));
        }*/
    }

    @Test
    public void testBase64() throws Exception {
        /*GifCaptcha PngCaptcha = new GifCaptcha();
        System.out.println(PngCaptcha.toBase64(""));*/
    }

}
