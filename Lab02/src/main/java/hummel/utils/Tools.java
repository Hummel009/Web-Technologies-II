package hummel.utils;

import hummel.bean.container.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static hummel.utils.Constants.PAGE_NUMBER;
import static hummel.utils.Constants.PAGE_SIZE;

public class Tools {
	private Tools() {
	}

	public static String getHash(String message) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = digest.digest(message.getBytes(StandardCharsets.UTF_8));

			StringBuilder hexString = new StringBuilder(2 * hashBytes.length);
			for (byte hashByte : hashBytes) {
				String hex = Integer.toHexString(0xff & hashByte);
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
		HttpSession session = request.getSession();
		Page params = (Page) session.getAttribute(sessionAttributeName);
		String pageNumber = request.getParameter(PAGE_NUMBER);
		String pageSize = request.getParameter(PAGE_SIZE);
		int iPageNumber;
		int iPageSize;
		if (pageNumber != null) {
			if (pageNumber.matches("\\d+")) {
				iPageNumber = Integer.parseInt(pageNumber);
				params.setPageNumber(iPageNumber);
			}
		}
		if (pageSize != null) {
			if (pageSize.matches("\\d+")) {
				iPageSize = Integer.parseInt(pageSize);
				params.setPageSize(iPageSize);
			}
		}
		session.setAttribute(sessionAttributeName, params);
		return params;
	}
}