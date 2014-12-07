class BlogListView extends Backbone.View
	el: '#blogApp'

	events:
		'click #add': 'addBlog'
	initialize: ->
		@$title = @$ '#title'
		@$message = @$ '#message'
		@collection = new BlogCollection()
		@collection.fetch
			reset: true
		@render()
		@listenTo @collection, 'add', @renderBlog

	render: ->
		@collection.each (item) ->
			@renderBlog item
		,@
		@

	renderBlog: (item) ->
		blogView = new BlogView
			model: item
		$('#blogList').append blogView.render().el

	addBlog: (e) ->
		e.preventDefault()
		if @$title.val() isnt '' and @$message.val() isnt ''
			@collection.create @add()
		@$title.val ''
		@$message.val ''
			
	add: ->
		title: @$title.val()
		message: @$message.val()
