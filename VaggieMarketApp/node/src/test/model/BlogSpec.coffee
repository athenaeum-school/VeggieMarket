describe 'モデルテスト', ->
  it 'defaultTest', ->
    blog = new Blog()
    expect(blog.has 'title').toBeTruthy()
    expect(blog.get 'title').toBe ''
    expect(blog.get 'message').toEqual 'なし'