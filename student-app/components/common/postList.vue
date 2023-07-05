<template>
	<view>
		<post v-for="(Post,index) in dataList" :key="Post.pid" :pid="Post.pid" 
			:title="Post.title" :brief="Post.brief" :goodNum="Post.goodNum" :commentNum="Post.commentNum"
			:collectNum="Post.collectNum" :type="Post.type" :accountId='Post.accountId'  :nickName='Post.nickName'>
		</post>
	</view>
</template>

<script>
	import post from './post.vue'
	export default {
		data() {
			return {
				// postList: [],
					// {
					// 	postid: 1,
					// 	imgUrl: '../../static/image/simple.jpg',
					// 	posttitle: '贴吧好玩捏',
					// 	posttext: '贴吧好玩捏贴吧好玩捏贴吧好玩捏',
					// 	likeNum: 99,
					// 	commentNum: 99,
					// 	collectionNum: 99,
					// 	type: 'web',
					// 	AccountId: 'uj666',
					// 	userImg: '../../static/image/header.png'
					// },
					// {
					// 	postid: 2,
					// 	imgUrl: '../../static/image/simple.jpg',
					// 	posttitle: '贴吧好玩捏',
					// 	posttext: '贴吧好玩捏贴吧好玩捏贴吧好玩捏',
					// 	likeNum: 1,
					// 	commentNum: 1,
					// 	collectionNum: 1,
					// 	type: 'java',
					// 	AccountId: 'uj666',
					// 	userImg: '../../static/image/header.png'
					// },
					// {
					// 	postid: 3,
					// 	imgUrl: '../../static/image/simple.jpg',
					// 	posttitle: '贴吧好玩捏',
					// 	posttext: '贴吧好玩捏贴吧好玩捏贴吧好玩捏',
					// 	likeNum: 199,
					// 	commentNum: 919,
					// 	collectionNum: 919,
					// 	type: 'springboot',
					// 	AccountId: 'uj666',
					// 	userImg: '../../static/image/header.png'
					// }

				
			}
		},
		props:[
			'dataList'
		],
		// onLaunch() {
		// 	// this.$request({
		// 	// 	url:'/post/getall',
		// 	// 	methods:'GET',
				
		// 	// }).then(res=>{
		// 	// 	console.log(res);
		// 	// 	this.postList=res;
		// 	// }).catch(err=>{
		// 	// 	console.log(err);
		// 	// })
		// 	uni.request({
		// 		url:'http://121.43.48.56/post/getall',
		// 		method:'GET',
		// 		success:(res)=> {
		// 			this.postList=res.data
		// 			console.log(this.postList)
		// 		}
		// 	})
		// },
		components: {
			post
		},

	}
</script>

<style>
	.post-list {
		width: 100%;
	}
</style>