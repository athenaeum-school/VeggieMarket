var BlogListView = Backbone.View.extend({
	el: "#blogapp",

	events:{
		"click #add": "addBlog" 
	},

	initialize:function(){
		this.$title = this.$('#title');
		this.$message = this.$('#message');
		this.collection = new BlogList();
		this.collection.fetch({reset:true});
		this.render();
		this.listenTo(this.collection,'add',this.renderBlog);
		this.listenTo(this.collection,'reset',this.render);
	},
	render:function(){
		this.collection.each(function(item) {
			this.renderBlog(item);
		},this);
		
	},
	renderBlog: function(item){
		var blogView = new BlogView({
			model:item
		});
	this.$('#blogList').append(blogView.render().el);
	},

	addBlog: function(e){
		e.preventDefault();
		if(this.$title.val() != '' && this.$message.val() != ''){
			this.collection.create(this.add());
		}
		this.$title.val('');
		this.$message.val('');
	},
	add: function(){
		return{
			title:this.$title.val(),
			message:this.$message.val()
		};
	},

	close: function(){
		this.stopListening();
	}

});