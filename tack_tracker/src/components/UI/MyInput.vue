<template>
    <input :value="modelValue" @input="updateInput"  class="input" type="text"> 
</template>

<script>
export default {
    props: {
        modelValue: [
            String,
            Number
        ]
    },
    methods: {
        updateInput(event) {
            this.$emit('update:modelValue', event.target.value)
        }
    }

}
</script>

<style>
.input{
    width: 100%;
    border: 1px solid green;
    padding: 10px;
    margin-top: 10px;
}

</style>