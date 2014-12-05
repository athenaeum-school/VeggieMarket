class BlogListView extends Backbone.View
	el: '#blogapp'

	initialize: ->
		@collection = new BlogCollection()

	render: ->
		@