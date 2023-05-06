import request from '@/utils/request'

const API = '/admin/system/sysUser'

export default {
  // 分页及带条件查询的方法
  findPageList(current, size, queryVo) {
    return request({
      url: `${API}/findByNamePage/${current}/${size}`,
      method: 'post',
      data: queryVo
    })
  },

  // 删除的方法
  delete(id) {
    return request({
      url: `${API}/removeUser/${id}`,
      method: 'delete'
    })
  },

  // 添加的方法
  save(sysUser) {
    return request({
      url: `${API}/saveUser`,
      method: 'post',
      data: sysUser
    })
  },

  // 根据id查询
  getById(id) {
    return request({
      url: `${API}/edit/${id}`,
      method: 'get'
    })
  },

  // 更新
  update(sysUser) {
    return request({
      url: `${API}/modifUser`,
      method: 'put',
      data: sysUser
    })
  },

  // 更新用户状态
  updateStatus(userId, status) {
    return request({
      url: `${API}/updateStatus/${userId}/${status}`,
      method: 'get'
    })
  }
}
