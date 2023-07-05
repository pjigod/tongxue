const baseUrl='http://121.43.48.56'
export const request = (option) =>{
	uni.showLoading({
		title:'加载中'
	})
	return new Promise((resolve,reject)=>{
		uni.request({
			url:baseUrl+option.url,
			method:option.method||'GET',
			header:{token:uni.getStorageSync('user')?uni.getStorageSync('user').token:''},
			data:option.data||{},
			success: (res) => {
				const data=res.data;
				setTimeout(function(){
					uni.hideLoading();
				},2000);
				if(data.code==='401'){
					uni.navigateTo({
						url:'/pages/login/login'
					})
					return
				} 
				resolve(data)
				
			},
			fail: (error) => {
				uni.showToast({
					title:'系统错误'
				})
				reject(error)
			}
		})
	})
}