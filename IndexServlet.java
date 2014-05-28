package com.appspot.twitterclicker;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// index.jspファイルに進む
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/WEB-INF/index.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("utf-8");
		
		// @otomohunter1129
		final String TWITTER_CONSUMER_KEY = "1McdM72IUDyBYp55EYTbHJrut"; // コンシューマーキー
		final String TWITTER_CONSUMER_SECRET = "VdwYw3Vi8uIN7vvvOmIMMI2FmG7erJSGho11pDjYCG6dL2WhdH"; // コンシューマーシークレット
		final String TWITTER_ACCESS_TOKEN = "612465140-UmvCQuXgTDUUfSGz6JvG30JUdaflx539dm007kRe"; // アクセストークン
		final String TWITTER_ACCESS_TOKEN_SECRET = "v6ir8xVQQlfilJ4h6QhszwD5D9hmIbn7T6SSgQWrIL8Ic"; // アクセストークンシークレット

		// アクセストークンの設定
		AccessToken token = new AccessToken(TWITTER_ACCESS_TOKEN,
				TWITTER_ACCESS_TOKEN_SECRET);

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(TWITTER_CONSUMER_KEY, TWITTER_CONSUMER_SECRET);
		twitter.setOAuthAccessToken(token);

		try {
			Iterator<Status> itr = twitter.getHomeTimeline().iterator();
			Status status = null;
			int i = 0;
			String[] userName = new String[20];
			String[] tweet = new String[20];
			String[] url = new String[20];
			while (itr.hasNext()) {
				status = itr.next();

				// 配列(ユーザ名)にそれぞれのユーザ名を格納する
				userName[i] = status.getUser().getScreenName();
				// 配列(ツイート文)にそれぞれのツイート文を格納する
				tweet[i] = status.getText();

				// ツイート文とツイート文に含まれているURL部分を分ける
				if (tweet[i].contains("http://")) {
					int index = tweet[i].indexOf("http://");
					url[i] = tweet[i].substring(index);
					tweet[i] = tweet[i].substring(0, index);
				} else if (tweet[i].contains("https://")) {
					int index = tweet[i].indexOf("https://");
					url[i] = tweet[i].substring(index);
					tweet[i] = tweet[i].substring(0, index);
				} else {
					url[i] = " ";
				}

				// ユーザ名に新しい属性を追加(JSPファイルに出力させるため)
				req.setAttribute("userName[" + i + "]", userName[i]);
				// ツイート文に新しい属性を追加(JSPファイルに出力させるため)
				req.setAttribute("tweet[" + i + "]", tweet[i]);
				// ツイート文のURLに新しい属性を追加(JSPファイルに出力させるため)
				req.setAttribute("url[" + i + "]", url[i]);

				i++;
			}
			// index_post.jspファイルに進む
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/WEB-INF/index_post.jsp");
			rd.forward(req, resp);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
