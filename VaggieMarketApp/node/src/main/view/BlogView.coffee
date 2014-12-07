class BlogView extends Backbone.View
	tagName: 'div'
	className: 'blogContainer'
	template: _.template($('#blogtemplate').html())

	events:
		'click .delete': 'deleteBlog'
		'dblclick .view': 'edit'
		'click .editbutton': 'edit'
		'click [name="save"]': 'saveBlog'
		'click [name="cancel"]': 'close'

	initialize: ->
		@listenTo @model, 'destroy', @remove
		@listenTo @model, 'change', @render

	render: ->
		@$el.html @template @model.toJSON()
		@$title = @$ '[name="title"]'
		@$message = @$ '[name="message"]'
		@

	deleteBlog: (e) ->
		e.preventDefault()
		@.model.destroy()

	edit: ->
		@$el.addClass 'editing'
		@$title.focus()

	saveBlog: (e) ->
		e.preventDefault()
		@model.save
			title: @$title.val()
			message: @$message.val()
		@close()

	close: ->
		@$el.removeClass 'editing'
