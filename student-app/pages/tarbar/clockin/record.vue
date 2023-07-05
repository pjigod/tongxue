<template>
	<view class="container">
		<view class="items">
			<recorditem v-for="(recorditem,index) in dataList" :key="index" :content="recorditem.content"
				:clockInDate="recorditem.clockInDate" :clockInTime="recorditem.clockInTime"></recorditem>
		</view>
	</view>

</template>

<script>
	import {
		mapState
	} from 'vuex'
	import recorditem from '@/components/common/recorditem.vue'
	export default {
		data() {
			return {
				dataList: []
			}
		},
		methods: {

		},
		computed: {
			...mapState({
				loginStatus: state => state.user.loginStatus,
				accountId: state => state.user.accountId,
			})
		},
		onLoad() {
			this.$request({
				url: '/user/clockinlog',
				methods: 'GET',
				data: {
					AccountId:this.accountId
				}
			}).then(res => {
				console.log(res);
				this.dataList = res;
			}).catch(err => {
				console.log(err);
			})
		},
		components: {
			recorditem
		}
	}
</script>

<style>

</style>