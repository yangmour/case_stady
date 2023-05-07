import request from '@/utils/request'

const api_name = "/admin/system/sysMenu"

export default {
    //查询所有菜单
    findMenuNodes(){
        return request({
            url:`${api_name}/findMenuNodes`,
            method:"get"
        });
    },

    //删除
    delete(id){
        return request({
            url:`${api_name}/delete/${id}`,
            method:"delete"
        });
    },

    //添加
    save(sysMenu){
        return request({
            url:`${api_name}/save`,
            method:"post",
            data:sysMenu
        });
    },

    //根据id查询
    getById(id){
        return request({
            url:`${api_name}/getById/${id}`,
            method:"get"
        });
    },

    //更新
    update(sysMenu){
        return request({
            url:`${api_name}/update`,
            method:"put",
            data:sysMenu
        });
    },

    //根据角色id查询角色的菜单
    toAssign(roleId){
        return request({
            url:`${api_name}/getRoleMenuList/${roleId}`,
            method:"get"
        });
    },

    //分配权限
    doAssign(assginMenuVo){
        return request({
            url:`${api_name}/assignMenu`,
            method:"post",
            data:assginMenuVo
        });
    }
}