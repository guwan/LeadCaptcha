package top.knos.captcha.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.knos.captcha.PngCaptcha;
import top.knos.captcha.base.Captcha;

import java.io.IOException;
import java.util.Locale;

/**
 * TODO
 *
 * @Author andy
 * @Date 2022/4/5 10:17
 */
public class CaptchaTextFactory {
    private static final String SESSION_KEY = "captcha";
    private static final int DEFAULT_LEN = 4;  // 默认长度
    private static final int DEFAULT_WIDTH = 130;  // 默认宽度
    private static final int DEFAULT_HEIGHT = 48;  // 默认高度
    private static final int DEFAULT_FONT_SIZE = 40;  // 默认字体大小




    /**
     * 获取验证码，并写入response
     * @param response
     * @return
     */
    public static String create(HttpServletResponse response) throws IOException {
        return create(response, DEFAULT_WIDTH, DEFAULT_HEIGHT,DEFAULT_LEN);
    }

    /**
     * 获取验证码，并写入response
     * @param response
     * @param width
     * @param height
     * @return
     * @throws IOException
     */
    public static String create(HttpServletResponse response, int width, int height) throws IOException {
        return create(response, width, height, DEFAULT_LEN);
    }

    /**
     * 获取验证码，并写入response
     * @param response
     * @param width
     * @param height
     * @param len
     * @return
     * @throws IOException
     */
    public static String create(HttpServletResponse response, int width, int height, int len) throws IOException {
        PngCaptcha pngCaptcha = new PngCaptcha(width, height, len);
        return create(response, pngCaptcha);
    }

    /**
     * 获取验证码，并写入response
     * @param response
     * @param captcha
     * @return
     * @throws IOException
     */
    public static String create(HttpServletResponse response, Captcha captcha) throws IOException {
        setHeader(response);
        String text = captcha.text();
        captcha.out(response.getOutputStream());
        return text.toLowerCase();
    }

    /**
     * 设置相应头
     *
     * @param response HttpServletResponse
     */
    public static void setHeader(HttpServletResponse response) {
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
    }
}
