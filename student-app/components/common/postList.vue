<template>
	<view>
	<post
	v-for="(Post,index) in postList"
	:key="Post.postid"
	:postid="Post.postid"
	:imgUrl="Post.imgUrl"
	:posttitle="Post.posttitle"
	:posttext="Post.posttext"
	:likeNum="Post.likeNum"
	:commentNum="Post.commentNum"
	:collectionNum="Post.collectionNum"
	></post>
	</view>
</template>

<script>
	import post from './post.vue'
export default{
	data(){
		return{
			postList:[
				{
					postid:1,
					imgUrl:'../../static/image/simple.jpg',
					posttitle:'贴吧好玩捏',
					posttext:'贴吧好玩捏贴吧好玩捏贴吧好玩捏',
					likeNum:99,
					commentNum:99,
					collectionNum:99,

				},
				{
					id:2,
					imgUrl:'../../static/image/simple.jpg',
					posttitle:'贴吧好玩捏',
					posttext:'贴吧好玩捏贴吧好玩捏贴吧好玩捏',
					likeNum:1,
					commentNum:1,
					collectionNum:1,

				},
				{
					id:3,
					imgUrl:'../../static/image/simple.jpg',
					posttitle:'贴吧好玩捏',
					posttext:'贴吧好玩捏贴吧好玩捏贴吧好玩捏',
					likeNum:199,
					commentNum:919,
					collectionNum:919,

				}
				
			]
		}
	},
	components:{
		post
	},
	
}
</script>

<style>
	.post-list{
		width: 100%;
	}
</style>