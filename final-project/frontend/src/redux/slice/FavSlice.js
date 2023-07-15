import {createSlice} from '@reduxjs/toolkit'
import { toast } from 'react-toastify'


export const FavSlice = createSlice({
    name:'addToFav',
    initialState:{
        value: localStorage.getItem('cartItem')? JSON.parse(localStorage.getItem('cartItem')):[]
    },
    reducers:{
        addToFav:(state,action)=>{
            if(state.value.find((item)=> item.id === action.payload.id)){
                toast.error("Already declared" , {
                    autoClose : 1000
                })
            }else{
                state.value.push(action.payload)
                localStorage.setItem('cartItem',JSON.stringify(state.value.map((item)=>item)))
                toast.success('Successfully added!', {
                    autoClose: 1000,
                  });
            }
            // state.value.push(action.payload)
            //     toast.success('Successfully added!')
            //     localStorage.setItem('cartItem',JSON.stringify(state.value.map((item)=>item)))

        },
        removeFromFav:(state,action)=>{
            let targetOfIndex = state.value.findIndex((item)=> item.id === action.payload)
            state.value.splice(targetOfIndex,1)
            toast.success('Successfully deleted!', {
                autoClose: 1000,
              });
            localStorage.setItem('cartItem',JSON.stringify(state.value.map((item)=>item)))
        }
    }
})

export const {addToFav,removeFromFav} = FavSlice.actions