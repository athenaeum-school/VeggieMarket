var Blog = Backbone.Model.extend({
	idAttribute: '_id',
	defaults:{
		title:'',
		message:'なし'
	},
	validate: function(attrs){
		if(_.isEmpty(attrs.title)){
			return '入力されていません。';
		}
	}
});