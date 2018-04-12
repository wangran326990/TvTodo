package com.tvtodo.api.errorhandler;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.tvtodo.api.util.RestUtil;

public class TvAPIErrorHandler implements ResponseErrorHandler {

	@Override
	public void handleError(ClientHttpResponse resp) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasError(ClientHttpResponse resp) throws IOException {
		return RestUtil.isError(resp.getStatusCode());
	}

}
