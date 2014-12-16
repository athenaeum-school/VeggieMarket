application_root = __dirname
express = require 'express'
path = require 'path'
mongoose = require 'mongoose'
app = express()
amqp = require 'amqplib'
when1 = require 'when'

allowCrossDomain = (req, res, next) ->
	res.header 'Access-Control-Allow-Origin', '*'
	res.header 'Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE'
	res.header 'Access-Control-Allow-Headers', 'Content-Type, Authorization'

	if 'OPTIONS' == req.method
		res.send 200
	else
		next()

app.use allowCrossDomain

app.configure ->
	app.use express.bodyParser()
	app.use express.methodOverride()
	app.use app.router
	app.use express.static path.join application_root, '/'
	app.use express.errorHandler
		dumpException: true
		showStack: true

mongoose.connect 'mongodb://localhost/VeggieMarket_blog'

Blog = new mongoose.Schema
	title: String
	message: String

BlogModel = mongoose.model 'blog', Blog

app.get '/api/blogs', (request,response) ->
	BlogModel.find (err,blogs) ->
		if !err
			response.send blogs
		else
			console.log err

app.get '/api/blogs/:id', (request,response) ->
	BlogModel.findById request.params.id, (err,blog) ->
		if !err
			response.send blog
		else
			console.log err

app.post '/api/blogs', (request,response) ->
	blog = new BlogModel
		title: request.body.title
		message: request.body.message
	amqp.connect('amqp://localhost').then (conn) ->
		when1 conn.createChannel().then (ch) ->
			q = 'blog'
			msg = JSON.stringify blog
			ok = ch.assertQueue q, {durable: false}
			ok.then (_qok) ->
				ch.sendToQueue q,new Buffer msg
				console.log " [x] Sent '%s'",msg
				ch.close()
		.ensure ->
			conn.close()
	.then null,console.warn

	blog.save (err) ->
		if not err
			console.log '追加されました。'
		else
			console.log err
	response.send blog


app.put '/api/blogs/:id', (request,response) ->
	console.log '更新します。: ' + request.body.title
	BlogModel.findById request.params.id, (err,blog) ->
		blog.title = request.body.title
		blog.message = request.body.message
		blog.save (err) ->
			if not err
				console.log '更新されました。'
			else
				console.log err
			response.send blog

app.delete '/api/blogs/:id', (request,response) ->
	console.log "削除するブログのID: #{request.params.id}"
	BlogModel.findById request.params.id, (err,blog) ->
		blog.remove (err) ->
			if !err
				console.log 'ブログが削除されました。'
			else
				console.log err

port = 9100
app.listen port, ->
	console.log "Expressサーバーがポート#{port}で起動しました。モード:#{app.settings.env}"