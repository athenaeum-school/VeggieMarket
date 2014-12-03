describe("モデルテスト", function() {
	it("spec1", function() {
		var blog = new Blog();

		expect(blog.has('title')).toBeTruthy();
		expect(blog.get('message')).toBe('なし');
		expect(blog.get('aaa')).toBeUndefined();
	});

	it("spec2", function() {
		var blog = new Blog({title:'abc',message:'def'});

		expect(blog.get('title')).toBe('abc');
		expect(blog.get('message')).toContain('e');
	});

	it("spec3", function() {
		var blog = new Blog();
		var obj = {abc:function(){}};
		spyOn(obj,'abc');
		blog.on('invalid', obj.abc);
		
		blog.set({title:''},{validate:true});
		
		expect(obj.abc).toHaveBeenCalled();
		

	});
});