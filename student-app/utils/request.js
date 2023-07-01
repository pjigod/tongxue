// export default {
// 	common: {
// 		baseUrl: "http://121.43.48.56",
// 		// 用于post请求
// 		header: {
// 			"Content-Type": "application/json",
// 			"Content-Type": "application/x-www-form-unlencoded"
// 		},
// 		data: {



// 		},
// 		method: "GET",
// 		dataType: "json"
// 	},
// 	request(option = {}) {
// 		option.url = this.common.baseUrl + option.url;
// 		option.data = option.data || this.common.data;
// 		option.method = option.method || this.common.method;
// 		option.header = option.header || this.common.header;
// 		option.dataType = option.dataType || this.common.dataType;
// 		return new Promise((res, rej) => {
// 				uni.request({
// 					...option,
// 					success: (result) => {
// 						if (result.statusCode !==200) {
// 							return rej();
// 						}
// 						let data = result.data.data;
// 						res(data);
// 					}
// 				})
// 			}

// 		)
// 	}
// }




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