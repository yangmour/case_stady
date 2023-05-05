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
  },
  save(sysRole) {
    return request({
      url: `${API}/saveRole/`,
      method: 'post',
      data: sysRole
    })
  },
  edit(id) {
    return request({
      url: `${API}/edit/${id}`,
      method: 'get'
    })
  },
  modifRole(sysRole) {
    return request({
      url: `${API}/modifRole/`,
      method: 'put',
      data: sysRole
    })
  }
}
