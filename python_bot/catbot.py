import asyncio
import time
from datetime import datetime
# import openpyxl

import discord
from discord.ext import commands
import random


token = "token"
game = discord.Game("뱃살 조물조물")
bot = commands.Bot(command_prefix='말랑아 ')


@bot.event
async def on_ready():
    # await bot.change_presence(status=discord.Status.offline)
    await bot.change_presence(status=discord.Status.online)
    await bot.change_presence(activity=discord.Game(game))
    print("봇 시작")

@bot.command()
async def 도움말(ctx):
    embed = discord.Embed(title=f"말랑이 :", description=f"고양이 봇으로 구르는게 다인 귀여운 아이입니다.", color=0xffb700)
    embed.add_field(value=f"지금 이 메세지를 보여줍니다", name=f"도움말", inline=False)
    embed.add_field(value=f"말랑이의 개인정보를 공개합니다.", name=f"자기소개", inline=False)
    embed.add_field(value=f"말랑이가 굴러줍니다.", name=f"굴러", inline=False)
    await  ctx.send(embed=embed)

@bot.command()
async def 굴러(ctx):
    await ctx.send("데구르르 몰캉")

@bot.command()
async def 자기소개(ctx):
    embed = discord.Embed(title=f"이름 :", description=f"말랑한 고양이", color=0xffb700)
    embed.set_thumbnail(url="https://i.imgur.com/BA5VRVE.png")
    embed.add_field(value=f"1살", name=f"나이 :", inline=False)
    embed.add_field(value=f"2020년 9월 14일", name=f"생일 :", inline=False)
    await  ctx.send(embed=embed)

@bot.command()
async def 에이(ctx):
    await ctx.send("에이야 굴러")

@bot.command()
async def 맞지(ctx):
    await ctx.send("녱!")

@bot.command()
async def 팀장(ctx):
    await ctx.send("여기요!<@360435715781165067>")

@bot.command()
async def 공실이(ctx):
    await ctx.send("잘자 원실아<@381368782981169154>")

@bot.command()
async def 말랑말랑(ctx):
    await ctx.send("말랑말랑랑")
@bot.command()
async def 핑(ctx):
    latancy = bot.latency
    await ctx.send(f'핑핑이 {round(latancy * 1000)}ms!')

# @bot.command()
# async def 배워(ctx):
#     file = openpyxl.load_workbook("리스트.xlsx")
#     sheet = file.active
#     learn = ctx.content.split(':')
#     for i in range(1, 51):
#         if sheet["A" + str(i)].value == "-":
#             await ctx.send("음... 그래")
#             sheet["A" + str(i)].value = learn[1]
#             shee" + str(i)].value == learn[1]:
#             await ctx.send("이미 있는 단어야")
#             breakt["B" + str(i)].value = learn[2]
#             break
#     file.save("리스트.xlsx")

@bot.event
async def on_message(message):
    message_content = message.content
    gumyeol = message_content.find("양하준")
    print(gumyeol)
    if gumyeol >= 0:
        await message.channel.send("그런건 부르는거 아니에요. 대신 104나.. 답안지를 불러보는건 어떤가요")
        await message.delete()
    await bot.process_commands(message)

@bot.event
async def on_member_join(member):
    await member.send("데굴데굴, 들어오셨어요?")







bot.run(token)
