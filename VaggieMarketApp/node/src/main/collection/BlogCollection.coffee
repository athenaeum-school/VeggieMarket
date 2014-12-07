class BlogCollection extends Backbone.Collection
	model: Blog

	localStorage: new Backbone.LocalStorage 'VaggieMarket'