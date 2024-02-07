package com.github.hummel.wt.lab3.utils;

import com.github.hummel.wt.lab3.bean.container.Page;
import jakarta.servlet.http.HttpServletRequest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public final class Tools {
	private static final Pattern PATTERN = Pattern.compile("\\d+");

	private Tools() {
	}

	public static String getHash(String message) {
		try {
			var digest = MessageDigest.getInstance("SHA-256");
			var hashBytes = digest.digest(message.getBytes(StandardCharsets.UTF_8));

			var hexString = new StringBuilder(2 * hashBytes.length);
			for (var hashByte : hashBytes) {
				var hex = Integer.toHexString(0xff & hashByte);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static Page updatePagingParams(HttpServletRequest request, String sessionAttributeName) {
		var session = request.getSession();
		var params = (Page) session.getAttribute(sessionAttributeName);
		var pageNumber = request.getParameter(Constants.PAGE_NUMBER);
		var pageSize = request.getParameter(Constants.PAGE_SIZE);
		if (pageNumber != null) {
			if (PATTERN.matcher(pageNumber).matches()) {
				var iPageNumber = Integer.parseInt(pageNumber);
				params.setPageNumber(iPageNumber);
			}
		}
		if (pageSize != null) {
			if (PATTERN.matcher(pageSize).matches()) {
				var iPageSize = Integer.parseInt(pageSize);
				params.setPageSize(iPageSize);
			}
		}
		session.setAttribute(sessionAttributeName, params);
		return params;
	}
}