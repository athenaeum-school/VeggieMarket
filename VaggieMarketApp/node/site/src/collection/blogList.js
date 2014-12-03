var BlogList = Backbone.Collection.extend({
	model:Blog,
	url:'http://localhost:8070/api/blogs'
});