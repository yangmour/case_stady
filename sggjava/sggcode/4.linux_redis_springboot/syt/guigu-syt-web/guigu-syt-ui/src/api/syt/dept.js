import request from '@/utils/request'
const apiName = '/admin/hosp/department'
export default {
  //查看医院科室
  getDeptByHoscode(hoscode) {
    return request ({
        url: `${apiName}/getDeptList/${hoscode}`,
        method: 'get'
    })
  },
}