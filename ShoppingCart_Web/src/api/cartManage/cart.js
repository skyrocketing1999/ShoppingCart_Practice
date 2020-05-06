import request from "@/utils/request.js";

/**
 * 获取商品
 * @param params
 * @returns {AxiosPromise}
 */
export function cartList(params) {
    return request({
        url: "/cart/list",
        method: "get",
        params: params
    });
}