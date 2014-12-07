class Blog extends Backbone.Model
	idAttribute: 'id'

	defaults:
		title: ''
		message: 'なし'

	localStorage: new Backbone.LocalStorage 'VaggieMarket'