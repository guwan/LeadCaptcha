package top.knos.captcha.utils;

import jakarta.servlet.http.HttpServletResponse;
import top.knos.captcha.PngCaptcha;
import top.knos.captcha.base.Captcha;
import top.knos.captcha.cache.CacheManager;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * 图形验证码工具类
 * 生成的验证码会写入session中
 * @author knos
 *
 */
public class LocalCaptchaUtil {
    private static final String SESSION_KEY = "captcha";
    private static final int DEFAULT_LEN = 4;  // 默认长度
    private static final int DEFAULT_WIDTH = 130;  // 默认宽度
    private static final int DEFAULT_HEIGHT = 48;  // 默认高度
    public static final int DEFAULT_EXPIRE = 5*60;  // 默认过期时间 秒

    /**
     * 输出验证码
     *
     * @param sessionId  String
     * @param response HttpServletResponse
     * @throws IOException IO异常
     */
    public static void out(String sessionId, HttpServletResponse response)
            throws IOException {
        out(DEFAULT_LEN, sessionId, response);
    }

    /**
     * 输出验证码
     *
     * @param len      长度
     * @param sessionId  String
     * @param response HttpServletResponse
     * @throws IOException IO异常
     */
    public static void out(int len, String sessionId, HttpServletResponse response)
            throws IOException {
        out(DEFAULT_WIDTH, DEFAULT_HEIGHT, len, sessionId, response);
    }

    /**
     * 输出验证码
     *
     * @param width    宽度
     * @param height   高度
     * @param len      长度
     * @param sessionId  String
     * @param response HttpServletResponse
     * @throws IOException IO异常
     */
    public static void out(int width, int height, int len, String sessionId, HttpServletResponse response)
            throws IOException {
        out(width, height, len, null, sessionId, response);
    }

    /**
     * 输出验证码
     *
     * @param font     字体
     * @param sessionId  String
     * @param response HttpServletResponse
     * @throws IOException IO异常
     */
    public static void out(Font font, String sessionId, HttpServletResponse response)
            throws IOException {
        out(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_LEN, font, sessionId, response);
    }

    /**
     * 输出验证码
     *
     * @param len      长度
     * @param font     字体
     * @param sessionId  String
     * @param response HttpServletResponse
     * @throws IOException IO异常
     */
    public static void out(int len, Font font, String sessionId, HttpServletResponse response)
            throws IOException {
        out(DEFAULT_WIDTH, DEFAULT_HEIGHT, len, font, sessionId, response);
    }

    /**
     * 输出验证码
     *
     * @param width    宽度
     * @param height   高度
     * @param len      长度
     * @param font     字体
     * @param sessionId  String
     * @param response HttpServletResponse
     * @throws IOException IO异常
     */
    public static void out(int width, int height, int len, Font font, String sessionId, HttpServletResponse response)
            throws IOException {
        PngCaptcha pngCaptcha = new PngCaptcha(width, height, len);
        if (font != null) {
            pngCaptcha.setFont(font);
        }
        out(pngCaptcha, sessionId, response);
    }


    /**
     * 输出验证码
     *
     * @param captcha  Captcha
     * @param sessionId  String
     * @param response HttpServletResponse
     * @throws IOException IO异常
     */
    public static void out(Captcha captcha, String sessionId, HttpServletResponse response)
            throws IOException {
        String text = CaptchaTextFactory.create(response,captcha);
        CacheManager.put(sessionId,text,DEFAULT_EXPIRE, TimeUnit.SECONDS);
        CaptchaTextFactory.create(response,captcha);
    }

    /**
     * 通过session验证验证码
     *
     * @param code    用户输入的验证码
     * @param sessionId String
     * @return 是否正确
     */
    public static boolean verify(String code, String sessionId) {
        if (code != null) {
            String captcha = (String)CacheManager.get(sessionId);
            return code.trim().toLowerCase().equals(captcha);
        }
        return false;
    }

    /**
     * 清除session中的验证码
     *
     * @param sessionId String
     */
    public static void clear(String sessionId) {
        CacheManager.refresh();
    }



}
