import request from '@/utils/request'

const apiName = '/admin/hosp/hospital'
export default {
  //医院列表
  getPageList(page, limit, hosname) {
    return request({
      url: `${apiName}/page/${page}/${limit}`,
      method: 'get',
      params: { hosname }
    })
  },

  updateStatus(hoscode, status) {
    return request({
      url: `${apiName}/updateStatus/${hoscode}/${status}`,
      method: 'get'
    })
  },
  //查看医院详情
  getHospByCode(hoscode) {
    return request({
      url: `${apiName}/detail/${hoscode}`,
      method: 'get'
    })
  },
  
}