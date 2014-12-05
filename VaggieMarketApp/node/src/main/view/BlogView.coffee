class BlogView extends Backbone.View
	tagName: 'div'
	className: 'blogContainer'
	template: _.template($('#blogtemplate').html())

	render: ->
		@$el.html @template 
		@