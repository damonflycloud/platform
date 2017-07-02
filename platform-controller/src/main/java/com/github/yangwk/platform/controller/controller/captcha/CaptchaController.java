package com.github.yangwk.platform.controller.controller.captcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octo.captcha.service.multitype.MultiTypeCaptchaService;

/**
 * Generates captcha image to tell whether its user is a human or a computer.
 * See http://forge.octo.com/jcaptcha/confluence/display/general/Home
 */
@Controller
@RequestMapping("/captcha")
public class CaptchaController {
	private static final String CAPTCHA_IMAGE_FORMAT = "jpeg";

	@Autowired
	private MultiTypeCaptchaService captchaService;

	@RequestMapping("/generate")
	public void generate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		byte[] captchaChallengeAsJpeg = null;
		// the output stream to render the captcha image as jpeg into
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			// get the session id that will identify the generated captcha.
			// the same id must be used to validate the response, the session id is a good candidate!

			String captchaId = request.getSession().getId();
			// call the ImageCaptchaService getChallenge method
			BufferedImage challenge = captchaService.getImageChallengeForID(captchaId, request.getLocale());

			ImageIO.write(challenge, CAPTCHA_IMAGE_FORMAT, jpegOutputStream);
			
			captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

			// flush it in the response
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/" + CAPTCHA_IMAGE_FORMAT);

			ServletOutputStream responseOutputStream = response.getOutputStream();
			responseOutputStream.write(captchaChallengeAsJpeg);
			responseOutputStream.flush();
			IOUtils.closeQuietly(responseOutputStream);
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	@ResponseBody
	@RequestMapping("/validate")
	public String validate(HttpServletRequest request,String captcha){
		boolean validCaptcha = false;
		String sessionId = request.getSession().getId();
		validCaptcha = captchaService.validateResponseForID(sessionId, captcha);
		return String.valueOf(validCaptcha);
	}
	
}