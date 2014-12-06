class BlogListView extends Backbone.View
	el: '#blogApp'

	events:
		'click #add': 'addBlog'
	initialize: ->
		@$title = @$ '#title'
		@$message = @$ '#message'
		@collection = new BlogCollection()
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
		@$title.val ''
		@$message.val ''

	addBlog: (e) ->
		e.preventDefault()
		if @$title.val() isnt '' and @$message.val() isnt ''
			@collection.add @add()
			
	add: ->
		title: @$title.val()
		message: @$message.val()
