import request from '@/utils/request'

const API = '/admin/system/sysRole'

export default {
  getRoleList(pageNum, pageSize, searchObj) {
    return request({
      url: `${API}/findByNamePage/${pageNum}/${pageSize}`,
      method: 'post',
      data: searchObj
    })
  },
  removeById(id) {
    return request({
      url: `${API}/removeRole/${id}`,
      method: 'delete'
    })
  },
  batchRemoveByIds(ids) {
    return request({
      url: `${API}/batchRemoveRole/`,
      method: 'post',
      data: ids
    })
  }
}
