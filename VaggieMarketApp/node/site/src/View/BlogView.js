var BlogView = Backbone.View.extend({
	tagName:'div',
	className:'blogContainer',
	template: _.template($('#blogtemplate').html()),

	events:{
		'click .delete':'deleteBlog',
		'dblclick .view':'edit',
		'click .editbutton':'edit',
		'click [name="save"]':'saveBlog',
		'click [name="cancel"]':'close'
	},

	initialize:function(){
		this.listenTo(this.model,'change',this.render);
		this.listenTo(this.model,'destroy',this.remove);
	},

	render: function(){
		this.$el.html(this.template(this.model.toJSON()));
		this.$title = this.$('[name="title"]');
		this.$message = this.$('[name="message"]');
		return this;
	},

	deleteBlog:function(e){
		e.preventDefault();
		this.model.destroy();
	},

	edit: function(){
		this.$el.addClass('editing');
		this.$title.focus();
	},

	saveBlog: function(e){
		e.preventDefault();
		console.log(this.$title.val());
		this.model.save(this.save());
		this.close();
		
	},

	save: function(){
		return{
			title:this.$title.val(),
			message:this.$message.val()
		};
	},
	close: function(){
		this.$el.removeClass('editing');
	}
});