<template>
	<view class="post">
		<!-- 单个帖子组件 -->
		<view class="post-item">
			<view class="post-title">
				<text class="fti-style">{{posttitle}}</text>
			</view>
			<view class="post-text">
				<text class="ft-style">{{posttext}}</text>
			</view>
			<view class="temp1"></view>
			<view class="post-image">
				<image :src='imgUrl' style="width: 80%;"></image>
			</view>

			<view class="temp2">

			</view>
			<view class="post-operate">
				<view class="like">
					<view class="like-image" @click="changeLikeStatus()">
						<image :src='likeStatus?"../../static/image/ic_like.png":"../../static/image/like.png"'
							style="width: 60%;height: 60%;"></image>
					</view>
					<view class="like-text">
						<text>{{likeStatus?likeNum+1:likeNum}}</text>
					</view>
				</view>
				<view class="comment">
					<view class="comment-image">
						<image src='../../static/image/comment.png' style="width: 50%;height: 50%;"></image>
					</view>
					<view class="comment-text">
						<text>{{commentNum}}</text>
					</view>
				</view>
				<view class="collection" @click="changeCollectionStatus(index)">
					<view class="collection-image">
						<image
							:src='collectionStatus?"../../static/image/collected.png":"../../static/image/collection.png"'
							style="width: 50%;height: 50%;"></image>
					</view>
					<view class="collection-text">
						<text>{{collectionStatus?likeNum+1:likeNum}}</text>
					</view>
				</view>
			</view>
			<view class="temp3">

			</view>
		</view>

	</view>











</template>

<script>
	export default {
		data() {
			return {
				likeStatus: false,
				collectionStatus: false,
			}
		},
		props: [
			'postid',
			'imgUrl',
			'posttitle',
			'posttext',
			'likeNum',
			'commentNum',
			'collectionNum',
		],

		methods: {
			changeLikeStatus() {
				this.likeStatus = !this.likeStatus;
			},
			changeCollectionStatus() {
				this.collectionStatus = !this.collectionStatus;
			}

		}
	}
</script>

<style>
	.temp1 {
		width: 100%;
		height: 10rpx;
	}

	.temp3 {
		width: 100%;
		height: 50rpx;
	}

	.post {
		width: 100%;

	}


	.post-image {
		display: flex;
		width: 100%;
		height: 500rpx;
		justify-content: center;
		align-items: center;
	}

	.ft-style {
		font-size: 30rpx;
		margin-left: 30rpx;
		color: #636263;
	}

	.fti-style {
		font-size: 50rpx;
		margin-left: 30rpx;
	}

	.post-operate {
		display: flex;
		flex-wrap: wrap;
		height: 150rpx;
		width: 100%;
	}

	.like {
		display: flex;
		flex-wrap: wrap;
		height: 100%;
		width: 32%;
		border: solid 2rpx #636263;
		margin-left: 10rpx;
	}

	.comment {
		display: flex;
		flex-wrap: wrap;
		height: 100%;
		width: 32%;
		border: solid 2rpx #636263;

	}

	.collection {
		display: flex;
		flex-wrap: wrap;
		height: 100%;
		width: 32%;
		border: solid 2rpx #636263;

	}

	.like-image {
		display: flex;
		width: 40%;
		height: 100%;
		justify-content: center;
		align-items: center;
	}

	.like-text {
		display: flex;
		width: 55%;
		height: 100%;
		justify-content: center;
		align-items: center;
	}

	.comment-image {
		display: flex;
		width: 40%;
		height: 100%;
		justify-content: center;
		align-items: center;
	}

	.comment-text {
		display: flex;
		width: 55%;
		height: 100%;
		justify-content: center;
		align-items: center;
	}


	.collection-image {
		display: flex;
		width: 40%;
		height: 100%;
		justify-content: center;
		align-items: center;
	}

	.collection-text {
		display: flex;
		width: 55%;
		height: 100%;
		justify-content: center;
		align-items: center;
	}
</style>