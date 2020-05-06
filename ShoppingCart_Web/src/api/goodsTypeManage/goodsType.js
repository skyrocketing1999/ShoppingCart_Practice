import request from "@/utils/request.js";

/**
 * 获取商品
 * @param params
 * @returns {AxiosPromise}
 */
export function goodsTypeList(params) {
    return request({
        url: "/goodsType/list",
        method: "get",
        params: params
    });
}
/**
 * 添加商品类型类型
 * @param params
 * @returns {AxiosPromise}
 */
export function addGoodsType(params) {
    return request({
        url: "/goodsType/add",
        method: "post",
        data: params
    });
}
