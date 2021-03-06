<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Hello WebSocket</title>
    <style>
    body { background-color: #f5f5f5; }
	#main-content {max-width: 940px;padding: 2em 3em;margin: 0 auto 20px;background-color: #fff;border: 1px solid #e5e5e5;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;}
    </style>
    <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/1.0.2/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/2.3.3/stomp.min.js"></script>
    <script src="/js/socketApp.js"></script>
</head>
<body>

	<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
	    enabled. Please enable
	    Javascript and reload this page!</h2></noscript>
	<div id="main-content" class="container">
	    <div class="row">
	        <div class="col-md-6">
	            <form class="form-inline">
	                <div class="form-group">
	                    <label for="connect">WebSocket connection:</label>
	                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
	                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
	                    </button>
	                </div>
	            </form>
	        </div>
	        <div class="col-md-6">
	            <form class="form-inline">
	                <div class="form-group">
	                    <label for="name">What is your name?</label>
	                    <input type="text" id="name" class="form-control" placeholder="Your name here...">
	                </div>
	                <button id="send" class="btn btn-default" type="submit">Send</button>
	            </form>
	        </div>
	    </div>
	    <div class="row">
	        <div class="col-md-12">
	            <table id="conversation" class="table table-striped">
	                <thead>
	                <tr>
	                    <th>Greetings</th>
	                </tr>
	                </thead>
	                <tbody id="greetings">
	                </tbody>
	            </table>
	        </div>
	    </div>
	</div>

</body>
</html>